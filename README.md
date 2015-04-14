# stopwatch

Small stopwatch library using java 8

Two types: mili-seconds, nano-seconds

## Usage
Using reference to a static method
```java
public class StopwatchTest {

	@Test
	public static void delay500ms() {
	
		// test user-defined static method 
		long delay = Stopwatch.mili(StopwatchTest::delay500ms);
		long delay10 = Stopwatch.mili(StopwatchTest::delay500ms, 10);
		
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
long delay = Stopwatch.nano(() -> {
	int sum = 0;
	for(int i = 0; i < 100; i++) {
		sum++;
	}
});
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

long delay = Stopwatch.mili(tooSlowOperation);
```
