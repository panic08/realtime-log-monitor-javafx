# Realtime Log Monitor (JavaFX)

**Realtime Log Monitor** is a JavaFX application for monitoring updates in text files in real-time. Ideal for analyzing log files and tracking changes as they happen

## Requirements

- **JDK 17** or higher
- **JavaFX SDK** compatible with your JDK version. You can download it from [Gluon](https://gluonhq.com/products/javafx/)

## How to Run

1. Ensure that the `PATH_TO_FX` environment variable points to the `lib` directory of your JavaFX SDK
2. Clone the repository:
   ```bash
   git clone https://github.com/panic08/realtime-log-monitor-javafx.git
   cd realtime-log-monitor-javafx
3. Build the project using Maven:
   ```bash
   mvn clean package
4. Run the application by specifying the JavaFX SDK path:
   ```bash
   java --module-path $PATH_TO_FX --add-modules javafx.controls -jar target/realtime-log-monitor-javafx.jar

## Usage

1. Specify the path to the text file you want to monitor
2. Observe real-time updates to the file