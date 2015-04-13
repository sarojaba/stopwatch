# stopwatch

small stopwatch library using java 8

## Usage
Using reference to a static method
```java
long delay = Stopwatch.mili().time(StopwatchTest::delay500ms);

long delay10 = Stopwatch.mili().time(StopwatchTest::delay500ms, 10);
  
public static void delay500ms() {
	try {
		Thread.sleep(500);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
}
```

Using lambda expression
```java
long delay = Stopwatch.nano().time(() -> {
	int sum = 0;
	for(int i = 0; i < 100; i++) {
		sum++;
	}
});
```

```java 
long delay100 = Stopwatch.nano().time(() -> {
	Math.random();
}, 100);
```
