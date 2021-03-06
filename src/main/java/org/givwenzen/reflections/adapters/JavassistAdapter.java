package org.givwenzen.reflections.adapters;

import static javassist.bytecode.AccessFlag.*;
import javassist.bytecode.*;
import javassist.bytecode.annotation.Annotation;

import org.givwenzen.reflections.ReflectionsException;
import org.givwenzen.reflections.util.DescriptorHelper;
import org.givwenzen.reflections.util.Utils;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class JavassistAdapter implements MetadataAdapter<ClassFile, FieldInfo, MethodInfo> {
    @SuppressWarnings("unchecked")
    public List<FieldInfo> getFields(final ClassFile cls) {
        //noinspection unchecked
        return cls.getFields();
    }

    @SuppressWarnings("unchecked")
    public List<MethodInfo> getMethods(final ClassFile cls) {
        //noinspection unchecked
        return cls.getMethods();
    }

    public String getMethodName(final MethodInfo method) {
        return method.getName();
    }

    public List<String> getParameterNames(final MethodInfo method) {
        return DescriptorHelper.methodDescriptorToParameterNameList(method.getDescriptor());
    }

    public List<String> getClassAnnotationNames(final ClassFile aClass) {
        AnnotationsAttribute annotationsAttribute = (AnnotationsAttribute) aClass.getAttribute(AnnotationsAttribute.visibleTag);
        return getAnnotationNames(annotationsAttribute);
    }

    public List<String> getFieldAnnotationNames(final FieldInfo field) {
        AnnotationsAttribute annotationsAttribute = (AnnotationsAttribute) field.getAttribute(AnnotationsAttribute.visibleTag);

        return getAnnotationNames(annotationsAttribute);
    }

    public List<String> getMethodAnnotationNames(final MethodInfo method) {
        AnnotationsAttribute annotationsAttribute = (AnnotationsAttribute) method.getAttribute(AnnotationsAttribute.visibleTag);

        return getAnnotationNames(annotationsAttribute);
    }

    public List<String> getParameterAnnotationNames(final MethodInfo method, final int parameterIndex) {
        ParameterAnnotationsAttribute parameterAnnotationsAttribute = (ParameterAnnotationsAttribute) method.getAttribute(ParameterAnnotationsAttribute.visibleTag);

        if (parameterAnnotationsAttribute != null) {
            Annotation[][] annotations = parameterAnnotationsAttribute.getAnnotations();
            Annotation[] annotation = annotations[parameterIndex];
            return getAnnotationNames(annotation);
        } else {
            return new ArrayList<String>();
        }
    }

    public String getReturnTypeName(final MethodInfo method) {
        return DescriptorHelper.methodDescriptorToReturnTypeName(method.getDescriptor());
    }

    public String getFieldName(final FieldInfo field) {
        return field.getName();
    }

    public ClassFile create(InputStream inputStream) throws IOException {
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(new BufferedInputStream(inputStream));
            return new ClassFile(dis);
        } finally {
            if (dis != null) {
                try {
                    dis.close();
                } catch (IOException e) {
                    //noinspection ThrowFromFinallyBlock
                    throw new ReflectionsException("could not close DataInputStream", e);
                }
            }
        }
    }

    public String getMethodModifier(MethodInfo method) {
        int accessFlags = method.getAccessFlags();
        return isPrivate(accessFlags) ? "private" :
               isProtected(accessFlags) ? "protected" :
               isPublic(accessFlags) ? "public" : "";
    }

    public String getMethodKey(ClassFile cls, MethodInfo method) {
        List<String> parameterNames = getParameterNames(method);
        String names = Utils.join(parameterNames, ", ");
        return String.format("%s %s %s.%s(%s)", getMethodModifier(method), getReturnTypeName(method), getClassName(cls),
                getMethodName(method), names);
    }

    //
    public String getClassName(final ClassFile cls) {
        return cls.getName();
    }

    public String getSuperclassName(final ClassFile cls) {
        return cls.getSuperclass();
    }

    public List<String> getInterfacesNames(final ClassFile cls) {
        return Arrays.asList(cls.getInterfaces());
    }

    //
    private List<String> getAnnotationNames(final AnnotationsAttribute annotationsAttribute) {
        if (annotationsAttribute == null) {return new ArrayList<String>(0);}

        final Annotation[] annotations = annotationsAttribute.getAnnotations();
        return getAnnotationNames(annotations);
    }

    private List<String> getAnnotationNames(final Annotation[] annotations) {
        List<String> result = new ArrayList<String>();

        for (Annotation annotation : annotations) {
            result.add(annotation.getTypeName());
        }

        return result;
    }
}
