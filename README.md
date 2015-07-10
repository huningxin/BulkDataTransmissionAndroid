# BulkDataTransmissionAndroid

## Build
```
javac com/example/extension/SharedMemExtension.java -classpath /path/to/xwalk_app_template/template/libs/xwalk_app_runtime_java.jar:/path/to/sdk/platforms/android-22/android.jar:/path/commons-codec-1.10/commons-codec-1.10.jar
```
```
jar cvf ./SharedMemExtension/SharedMemExtension.jar com/example/extension/SharedMemExtension.class
```
## Package
```
make_apk.py --name=SharedMemExtension --package=com.example.sharedmemextension --extensions=./extension/SharedMemExtension/ --app-root=./AsyncSharedMemExtensionDemo/ --app-local-path=index.html --enable-remote-debugging
```
