
```
ext {
    bintrayRepo = '仓库名'
    bintrayName = '项目名'

    publishedGroupId = '包名'
    libraryName = '可以写项目名'
    artifact = '项目'

    libraryDescription = 'The gradient ui that View can change from one background to another background. (Such as the background of ImageView, the color of TextView)'

    siteUrl = '项目地址'
    gitUrl = '项目git地址'

    libraryVersion = '库版本'

    developerId = '开发者ID'
    developerName = '开发者名称'
    developerEmail = '开发者邮箱'

    licenseName = 'The Apache Software License, Version 2.0'
    licenseUrl = 'http://www.apache.org/licenses/LICENSE-2.0.txt'
    allLicenses = ["Apache-2.0"]
}

apply from: 'https://raw.githubusercontent.com/nuuneoi/JCenter/master/installv1.gradle'
apply from: 'https://raw.githubusercontent.com/nuuneoi/JCenter/master/bintrayv1.gradle'
```

```
classpath 'com.jfrog.bintray.gradle:gradle-bintray-plugin:1.2'
classpath "org.jfrog.buildinfo:build-info-extractor-gradle:3.1.1"
classpath 'com.github.dcendents:android-maven-gradle-plugin:1.5'
```

#### MAC

```
./gradlew install
./gradlew bintrayUpload
```
#### WINDOWS
   
```
gradlew install
gradlew bintrayUpload
```

####FAQ
```
Q:-bash: ./gradlew: Permission denied

A:chmod +x gradlew 

```