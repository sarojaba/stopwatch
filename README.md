# stopwatch

Small stopwatch library using java 8

* Two types: mili-seconds, nano-seconds
* support iteration, multi test

## Usage
Using reference to a static method
```java
public class StopwatchTest {

	@Test
	public static void delay500ms() {
	
		// test user-defined static method 
		long delay = Stopwatch.task(StopwatchTest::delay500ms).mili().time();
		long delay10 = Stopwatch.task(StopwatchTest::delay500ms, 10).mili().time();
		
		// test method using iteration
		long delay100 = Stopwatch.nano(Math::random(), 100);
	}
  
	public static void delay500ms() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
```

Using lambda expression
```java
long delay = Stopwatch.task(() -> {
	int sum = 0;
	for(int i = 0; i < 100; i++) {
		sum++;
	}
}).nano().time();
```

Using runnable object
```java
Runnable tooSlowOperation = new Runnable() {
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
};

long delay = Stopwatch.task(tooSlowOperation).mili().time();
```

Using reference to a main method
```java
class Sample {
	public static void main(String[] args) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

long delay = Stopwatch.task(Sample::main).mili().time();
```

Using builder pattern for method chaining
```java
Stopwatch.task(StopwatchTest::delay500ms)
	.task(tooSlowOperation)
	.task(Sample::main).mili()
```

Pretty toString()
```java
System.out.println(Stopwatch.task(Sample::main).nano()); // 1,000,161,095 ns
```
