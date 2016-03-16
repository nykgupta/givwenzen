### System.out.println alternative in Slim ###

If a step is failing and you want to see what the actual value is you can add a step to show it:
```
|show|then|what the total is|
```

---

```
@DomainStep("what the total is")
public String whatIsTheTotal() {
  return total;
}
```