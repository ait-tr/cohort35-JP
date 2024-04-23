## 

Freemarker — это шаблонизатор на Java, который помогает разработчикам генерировать HTML-страницы, конфигурационные файлы и другие текстовые форматы, используя шаблоны. Этот инструмент широко применяется для создания веб-страниц в Java-приложениях. Вот подробное описание работы с Freemarker для создания страниц в Java-приложении:

### Основы Freemarker

Freemarker не обрабатывает HTML сам по себе; он создаёт HTML-файлы на основе шаблонов, которые вы определяете. Шаблоны Freemarker написаны в собственном декларативном языке и содержат статический текст (который будет частью конечного документа) и директивы Freemarker, которые управляют созданием динамического контента.

### Компоненты Freemarker

1. **Шаблоны**: Шаблоны Freemarker (обычно с расширением `.ftl`) — это текстовые файлы, содержащие фиксированный текст и специальные конструкции для динамической вставки данных.

2. **Модель данных**: Данные, которые должны быть вставлены в шаблон, обычно представлены в виде карты (Map) или другой структуры данных в Java, которая передаётся в шаблонизатор при обработке.

3. **Конфигурация**: Объект Configuration в Freemarker управляет всеми аспектами поведения шаблонизатора, включая спецификации форматирования, локализацию и другие настройки.

### Пример работы с Freemarker

#### 1. Настройка

Перед использованием Freemarker в вашем проекте добавьте зависимость в ваш `pom.xml` или `build.gradle` файл:

```xml
<!-- Для Maven -->
<dependency>
    <groupId>org.freemarker</groupId>
    <artifactId>freemarker</artifactId>
    <version>2.3.31</version> <!-- Проверьте последнюю версию -->
</dependency>
```

```groovy
// Для Gradle
implementation 'org.freemarker:freemarker:2.3.31' // Проверьте последнюю версию
```

#### 2. Создание конфигурации

```java
import freemarker.template.Configuration;
import freemarker.template.Version;

Configuration cfg = new Configuration(new Version("2.3.31"));
cfg.setDirectoryForTemplateLoading(new File("/path/to/templates"));
cfg.setDefaultEncoding("UTF-8");
cfg.setLocale(Locale.US);
cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
```

#### 3. Подготовка модели данных

```java
Map<String, Object> root = new HashMap<>();
root.put("user", "John Doe");
List<String> messages = Arrays.asList("Your application is up and running.", "Enjoy Freemarker!");
root.put("messages", messages);
```

#### 4. Обработка шаблона

```java
/* Загрузите шаблон */
Template temp = cfg.getTemplate("test.ftl");

/* Соедините модель данных с шаблоном и выводите результаты */
try (Writer out = new OutputStreamWriter(System.out)) {
    temp.process(root, out);
}
```

#### 5. Шаблон test.ftl

```plaintext
<html>
<head>
  <title>Welcome</title>
</head>
<body>
  <h1>Welcome ${user}!</h1>
  <p>Messages:</p>
  <ul>
  <#list messages as message>
    <li>${message}</li>
  <#list>
  </ul>
</body>
</html>
```

Этот пример демонстрирует базовый процесс создания HTML-страницы с использованием динамических данных. 
Freemarker мощный и гибкий, поддерживающий сложные операции с данными и форматированием текста.

## Тестирование контроллеров в Spring Boot 

Тестирование контроллеров в Spring Boot обычно включает использование фреймворка `MockMvc`, который позволяет отправлять HTTP-запросы на контроллеры и проверять ответы без запуска полноценного сервера. Вот подробное объяснение основных методов и подходов:

### 1. Инициализация `MockMvc`

- **`MockMvcBuilders.standaloneSetup`**: Этот метод используется для создания конфигурации `MockMvc` для тестирования одного или нескольких контроллеров в изоляции от остальной части приложения. Это идеально подходит для модульного тестирования, так как не требуется загружать полный контекст Spring.
- **`MockMvcBuilders.webAppContextSetup`**: Этот метод требует загрузки полного веб-контекста приложения, что делает его подходящим для интеграционных тестов.

### 2. Конфигурация тестов

- **`@SpringBootTest`**: Эта аннотация используется для загрузки полноценного контекста приложения и применяется в интеграционных тестах, подходит для проверки реального поведения приложения в среде, максимально приближенной к продуктивной.
- **`@WebMvcTest`**: Специализированная аннотация для тестирования MVC контроллеров, которая загружает только необходимые для контроллера компоненты, такие как конвертеры и валидаторы, без запуска полного контекста Spring.

### 3. Настройка и использование `MockMvc`

- **`.perform(RequestBuilder requestBuilder)`**: Основной метод для отправки HTTP-запросов. `RequestBuilder` создается для имитации различных HTTP-запросов, как `get()`, `post()` и др.
- **`.andExpect(ResultMatcher matcher)`**: Метод для проверки ответов контроллера. Позволяет проверить статус ответа, содержимое ответа, заголовки и другие аспекты.

### 4. Проверка результатов

- **`status()`**: Проверка статуса HTTP-ответа, например, успешен ли он (`isOK()`) или привел ли к ошибке (`isBadRequest()`).
- **`jsonPath(String expression, Matcher<?> matcher)`**: Используется для проверки конкретных данных в JSON-ответе, например, содержит ли поле `name` в ответе ошибку валидации.

### 5. Обработка исключений и мокирование

- **`@MockBean`**: Аннотация для добавления моков в контекст Spring теста. Позволяет заменить реальные бины на подделки для контроля поведения зависимостей.
- **`when()` и `thenReturn()`**: Методы из библиотеки Mockito для настройки поведения моков. Например, можно настроить мок сервиса так, чтобы при вызове метода возвращалось исключение или специфический результат.

Эти методы и подходы позволяют гибко настраивать тестирование контроллеров в Spring Boot, обеспечивая как широкое покрытие функциональности, так и детализированную проверку каждого аспекта взаимодействия клиента с сервером.
