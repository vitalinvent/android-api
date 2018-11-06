[![](https://jitpack.io/v/kassatka-online/android-api.svg)](https://jitpack.io/#kassatka-online/android-api)


## Добавление библиотеки к проекту 


В build.gradle проекта добавьте ссылку на репозиторий jitpack:


```
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
    }
}
```

в модуле `build.gradle` добавьте зависимость и укажите точную версию:


```
implementation 'com.github.kassatka-online:android-api:' + apiLatestVersion
```

где, apiLatestVersion определена в секции ext того же build.gradle файла. Также необходимо указать minSdkVersion проекта:


```
defaultConfig {
	minSdkVersion 22
	
	...

}
```

В этом проекте реализованы все доступные интерфейсы, константы и пр., необходимые для работы с оборудованием на смарт-терминале Кассатка.
