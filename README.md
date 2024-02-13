# TestSpark

![Build](https://github.com/JetBrains-Research/TestSpark/workflows/Build/badge.svg)
[![Version](https://img.shields.io/jetbrains/plugin/v/21024-testspark.svg)](https://plugins.jetbrains.com/plugin/21024-testspark)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/21024-testspark.svg)](https://plugins.jetbrains.com/plugin/21024-testspark)

![TestSpark Logo](readme-images/pngs/TestSpark_Plugin_logo.png#gh-light-mode-only)
![TestSpark White Logo](readme-images/pngs/TestSpark_Plugin_logo_dark.png#gh-dark-mode-only)
## Description

<!-- Plugin description -->
TestSpark is a plugin for generating unit tests. TestSpark natively integrates different AI-based test generation tools and techniques in the IDE.

TestSpark currently supports two test generation strategies:
<ul>
        <li>LLM-based test generation (using <a href="https://openai.com">OpenAI</a> and JetBrains internal AI Assistant platform)</li>
        <li>Local search-based test generation (using <a href="https://www.evosuite.org">EvoSuite</a>)</li>
</ul>
<h4>LLM-based test generation</h4>
    <p>For this type of test generation, TestSpark sends request to different Large Language Models. Also, it automatically checks if tests are valid before presenting it to users.</p>
    <p>This feature needs a token from OpenAI platform or the AI Assistant platform.</p>
    <ul>
        <li>Supports Java (any version).</li>
        <li>Generates unit tests for capturing failures.</li>
        <li>Generate tests for Java classes, methods, and single lines.</li>
    </ul>

<h4>Local search-based test generation</h4>
<p>For this type of test generation, TestSpark uses <a href="https://www.evosuite.org">EvoSuite</a>, which is the  most powerful search-based local test generator. </p>
<ul>
<li>Supports up to Java 11.</li>
<li>Generates tests for different test criteria: line coverage, branch coverage, I/O diversity, exception coverage, mutation score.</li>
<li>Generates unit tests for capturing failures.</li>
<li>Generate tests for Java classes, methods, and single lines.</li>
</ul>


<p>Initially implemented by <a href="https://www.ciselab.nl">CISELab</a> at <a href="https://se.ewi.tudelft.nl">SERG @ TU Delft</a>, TestSpark is currently developed and maintained by <a href="https://lp.jetbrains.com/research/ictl/">ICTL at JetBrains Research</a>.</p>

## <span style="color:crimson; font-size:150%; font-weight:bold"> DISCLAIMER </span>
<span style="color:crimson; font-size:150%; font-weight:bold">TestSpark is currently designed to serve as an experimental tool.</span>
<span style="color:crimson; font-size:150%; font-weight:bold">Please keep in mind that tests generated by TestSpark are meant to augment your existing test suites. They are not meant to replace writing tests manually.</span>

## Installation

- Using IDE built-in plugin system:

  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>Marketplace</kbd> > <kbd>Search for "TestSpark"</kbd> >
  <kbd>Install Plugin</kbd>

- Manually:

  Download the [latest release](https://github.com/ciselab/TestSpark/releases/latest) and install it manually using
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>


## Usage
<!-- How to use the plugin? What are the limitations? Are there any shortcuts? -->
### Important note before generating tests
If you are running the plugin for the first time, checkout the [Configuration](#configuration) section.

- [Generating Tests for Classes](#generating-tests-for-classes)
- [Generating Tests for Methods](#generating-tests-for-methods)
- [Generating Tests for Lines](#generating-tests-for-lines)
- [Working with Test Cases](#working-with-test-cases)
- [Coverage](#coverage)
- [Killed mutants visualisation](#killed-mutants-visualisation)
- [Integrating tests into the project](#integrating-tests-into-the-project)
- [Accessibility features](#accessibility-features)
- [Telemetry](#telemetry-opt-in)
- [Configuration](#configuration)

### Generating Tests for Classes
To generate a test for a class, right-click (with mouse) anywhere within the class you want to test or right-click the class name itself (note that when using multiple cursors only the last one will count). Under the "TestSpark" option, select the test generator and "class [...]" option. After setting up the selected test generator, test generation will start.

![Test generation for classes](readme-images/gifs/testClass.gif#gh-light-mode-only)
![Test generation for classes dark](readme-images/gifs/testClass_dark.gif#gh-dark-mode-only)

### Generating Tests for Methods
To generate a test for a method, right-click (with mouse) anywhere within the method you want to test or right-click the method name itself (note that when using multiple cursors only the last one will count). Under the "TestSpark" option, select the test generator and "method [...]" option. After setting up the selected test generator, test generation will start.

![Test generation for methods](readme-images/gifs/testMethod.gif#gh-light-mode-only)
![Test generation for methods dark](readme-images/gifs/testMethod_dark.gif#gh-dark-mode-only)

### Generating Tests for Lines
To generate a test for a method, right-click (with mouse) anywhere within the line you want. Note that the line has to contain a statement (e.g. you will not have the option on lines with only method declarations). Under the "TestSpark" option, select the test generator and "line [...]" option. After setting up the selected test generator, test generation will start.

![Test generation for methods](readme-images/gifs/testLine.gif#gh-light-mode-only)
![Test generation for methods dark](readme-images/gifs/testLine_dark.gif#gh-dark-mode-only)

### Working with Test Cases
After receiving the results, the user can interact with the test cases in various ways. They can view the result (whether it's passed or failed), also select, delete, modify, reset, like/dislike, fix by LLM and execute the tests to update the results.\
Hitting the "Apply to test suite" button will add the selected tests to a test class of your choice.\
Additionally, the top row of the tool window has buttons for selecting all tests, deselecting all tests, running all tests and removing them. The user also has an overview of how many tests they currently have selected and passed.

![Quick buttons](readme-images/pngs/selectAll.png#gh-light-mode-only)
![Quick buttons dark](readme-images/pngs/selectAll_dark.png#gh-dark-mode-only)

#### Select Test
Users can select test cases.

![Select test case](readme-images/gifs/selectTestCase.gif#gh-light-mode-only)
![Select test case dark](readme-images/gifs/selectTestCase_dark.gif#gh-dark-mode-only)

#### Remove Test
Users can remove test cases.

![Remove test case](readme-images/gifs/deleteTestCase.gif#gh-light-mode-only)
![Remove test case dark](readme-images/gifs/deleteTestCase_dark.gif#gh-dark-mode-only)

#### Modify Test
Users can modify the code of test cases.

![Modify test case](readme-images/gifs/modifyTestCase.gif#gh-light-mode-only)
![Modify test case dark](readme-images/gifs/modifyTestCase_dark.gif#gh-dark-mode-only)

#### Reset Test
Users can reset the code to its original.

![Reset test case](readme-images/gifs/resetTestCase.gif#gh-light-mode-only)
![Reset test case dark](readme-images/gifs/resetTestCase_dark.gif#gh-dark-mode-only)

#### Reset to Last Run
Users can reset the code to the last run.

![Reset to last run](readme-images/gifs/resetToLastRunTestCase.gif#gh-light-mode-only)
![Reset to last run dark](readme-images/gifs/resetToLastRunTestCase_dark.gif#gh-dark-mode-only)

#### Run Test
Users can run the test to update the execution result.\
Effortlessly identify passed and failed test cases with green and red color highlights for instant result comprehension is available. In case of failure, it is possible to find out the current error.

![Run test](readme-images/gifs/runTestCase.gif#gh-light-mode-only)
![Run test dark](readme-images/gifs/runTestCase_dark.gif#gh-dark-mode-only)

#### Copy Test
Users can copy the test.

![Copy test](readme-images/gifs/copyTestCase.gif#gh-light-mode-only)
![Copy test dark](readme-images/gifs/copyTestCase_dark.gif#gh-dark-mode-only)

#### Like/Dislike Test
Users can like/dislike the test for future analysis and improvement of the generation process.

![Like test](readme-images/gifs/likeTestCase.gif#gh-light-mode-only)
![Like test dark](readme-images/gifs/likeTestCase_dark.gif#gh-dark-mode-only)

#### Send a Request to LLM
Users can send a request to LLM with modification which users prefer for the test case.

![Send a request to LLM](readme-images/gifs/send.gif#gh-light-mode-only)
![Send a request to LLM dark](readme-images/gifs/send_dark.gif#gh-dark-mode-only)

### Coverage
#### Coverage Table
Once a test suite is generated, basic statistics about it can be seen in the tool window, `coverage` tab. The statistics include line coverage, branch coverage, weak mutation coverage. The table adjusts dynamically - it only calculates the statistics for the selected tests in the test suite.

![Progress bar](readme-images/pngs/coverageTable.png#gh-light-mode-only)
![Progress bar dark](readme-images/pngs/coverageTable_dark.png#gh-dark-mode-only)

#### Coverage Visualisation
Once test are generated, the lines which are covered by the tests will be highlighted (default color: green). The gutter next to the lines will have a green rectangle as well. If the rectangle is clicked, a popup will show the names of the tests which cover the selected line. If any of the test names are clicked, the corresponding test in the toolwindow will be highlighted with the same accent color. The effect lasts 10 seconds. Coverage visualisation adjusts dynamically - it only shows results for the tests that are selected in the TestSpark tab.

![Test Highlight](readme-images/gifs/testHighlight.gif#gh-light-mode-only)
![Test Highlight dark](readme-images/gifs/testHighlight_dark.gif#gh-dark-mode-only)

For reference, without visualisation the window would look like this:

![No Test Highlight](readme-images/pngs/NoCoverageVisualisation.png#gh-light-mode-only)
![No Test Highlight dark](readme-images/pngs/NoCoverageVisualisation_dark.png#gh-dark-mode-only)

#### Killed Mutants Visualisation
For mutation visualisation to work, you must have [coverage visualisation](#coverage-visualisation-1) enabled. You must also have the criterion `Mutation coverage` turned on. The setting is available in the <kbd>Settings</kbd> > <kbd>Tools</kbd> > <kbd>TestSpark</kbd> > <kbd>EvoSuite</kbd> tab.

![Turn on Mutation](readme-images/pngs/turnOnMutation.png#gh-light-mode-only)
![Turn on Mutation dark](readme-images/pngs/turnOnMutation_dark.png#gh-dark-mode-only)

Once tests are generated, the same gutter from [`Coverage Visualisation`](#coverage-visualisation-1) can be used to show which mutants are covered by the current test suite and which ones are not. For mutants covered, the mutant can be clicked. Clicking the mutant will highlight all the tests that kill the mutant. Mutation visualisation adjusts dynamically - it only shows results for the tests that are selected in the TestSpark tab.

![Mutation Coverage](readme-images/gifs/mutationHighlight.gif#gh-light-mode-only)
![Mutation Coverage dark](readme-images/gifs/mutationHighlight_dark.gif#gh-dark-mode-only)

### Integrating Tests into the Project
The tests can be added to an existing file:

![Tests adding to an exiting file](readme-images/gifs/addingToAnExistingFile.gif#gh-light-mode-only)
![Tests adding to an exiting file dark](readme-images/gifs/addingToAnExistingFile_dark.gif#gh-dark-mode-only)

Or to a new file:

![Tests adding to a new file](readme-images/gifs/addingToANewFile.gif#gh-light-mode-only)
![Tests adding to a new file_dark](readme-images/gifs/addingToANewFile_dark.gif#gh-dark-mode-only)

### Accessibility Features
The plugin supports changing the color for [coverage visualisation](#coverage-visualisation-1) and [killed mutants visualisation](#killed-mutants-visualisation-1) (one setting for both). To change the color, go to <kbd>Settings</kbd> > <kbd>Tools</kbd> > <kbd>TestSpark</kbd> and use the color picker under `Accessibility settings`:

![Color Picker](readme-images/pngs/colorPicker.png#gh-light-mode-only)
![Color Picker dark](readme-images/pngs/colorPicker_dark.png#gh-dark-mode-only)

The plugin has been designed with translation in mind. The vast majority of the plugins labels, tooltips, messages, etc. is stored in <kbd>.property</kbd> files. For more information on translation, refer to the contributing readme.

### Telemetry (opt-in)
One of the biggest future plans of our client is to leverage the data that is gathered by TestSpark’s telemetry. This will help them with future research, including the development of an interactive way of using EvoSuite. The general idea behind this feature is to learn from the stored user corrections in order to improve test generation.\
To opt into telemetry, go to <kbd>Settings</kbd> > <kbd>Tools</kbd> > <kbd>TestSpark</kbd> and tick the `Enable telemetry` checkbox. If you want, change the directory where telemetry is stored.

![Telemetry](readme-images/pngs/telemetry.png#gh-light-mode-only)
![Telemetry dark](readme-images/pngs/telemetry_dark.png#gh-dark-mode-only)

### Configuration
<!-- How can users configure the plugin to match their needs? -->
The plugin is configured mainly through the Settings menu. The plugin settings can be found under <kbd>Settings</kbd> > <kbd>Tools</kbd> > <kbd>TestSpark</kbd>. Here, the user is able to select options for the plugin:

![Plugin Settings](readme-images/pngs/PluginSettings.png#gh-light-mode-only)
![Plugin Settings dark](readme-images/pngs/PluginSettings_dark.png#gh-dark-mode-only)

#### First time configuration
Before running the plugin for the first time, we highly recommend going to the `Environment settings` section of TestSpark settings. The settings include compilation path (path to compiled code) and compilation command. Both commands have defaults. However, we recommend especially that you check compilation command. For this command the user requires maven, gradle or any other builder program which can be accessed via command. Leaving this field with a faulty value may cause unintended behaviour.

![Setup](readme-images/pngs/Setup.png#gh-light-mode-only)
![Setup dark](readme-images/pngs/Setup_dark.png#gh-dark-mode-only)

Also, the parameters for the generators have to be configured. Check [EvoSuite Parameters](#evosuite-parameters) and [LLM Parameters](#llm-parameters).

#### EvoSuite Settings
<!-- How to use Advanced Parameters Settings entry? Where to find it? What can be changed? --> 
The settings submenu <kbd>Settings</kbd> > <kbd>Tools</kbd> > <kbd>TestSpark</kbd> > <kbd>EvoSuite</kbd> allows the user to tweak EvoSuite parameters to their liking.\
At the moment EvoSuite can be executed only with Java 11, so if the user has a more modern version by default, it is necessary to download Java 11 and set the path to the java file.

![Java Setup](readme-images/pngs/JavaSetup.png#gh-light-mode-only)
![Java Setup dark](readme-images/pngs/JavaSetup_dark.png#gh-dark-mode-only)

EvoSuite has hundreds of parameters, not all can be packed in a settings menu. However, the most commonly used and rational settings were added here:

![EvoSuite Settings](readme-images/pngs/EvoSuiteSettings.png#gh-light-mode-only)
![EvoSuite Settings dark](readme-images/pngs/EvoSuiteSettings_dark.png#gh-dark-mode-only)

#### LLM Settings
The settings submenu <kbd>Settings</kbd> > <kbd>Tools</kbd> > <kbd>TestSpark</kbd> > <kbd>LLM</kbd> allows the user to tweak LLM parameters to their liking.

![LLM Settings](readme-images/pngs/LLMSettings.png#gh-light-mode-only)
![LLM Settings dark](readme-images/pngs/LLMSettings_dark.png#gh-dark-mode-only)

Selecting a platform to interact with the LLM. By default, only OpenAI is available, but for JetBrains employees there is an option to interact via Graize. More details in the [TestSpark for JetBrains employees](#testspark-for-jetbrains-employees) section.

![LLM Platform](readme-images/pngs/LLMPlatform.png#gh-light-mode-only)
![LLM Platform dark](readme-images/pngs/LLMPlatform_dark.png#gh-dark-mode-only)

Users have to set their own token for LLM, the plugin does not provide a default option.

![LLM Token](readme-images/pngs/LLMToken.png#gh-light-mode-only)
![LLM Token dark](readme-images/pngs/LLMToken_dark.png#gh-dark-mode-only)

Once the correct token is entered, it will be possible to select an LLM model for test generation.

![LLM Model](readme-images/pngs/LLMModel.png#gh-light-mode-only)
![LLM Model dark](readme-images/pngs/LLMModel_dark.png#gh-dark-mode-only)

In addition to the token, users are recommended to configure settings for the LLM process.

![LLM Parameters](readme-images/pngs/LLMParameters.png#gh-light-mode-only)
![LLM Parameters dark](readme-images/pngs/LLMParameters_dark.png#gh-dark-mode-only)

Users have the opportunity to adjust the prompt that is sent to the LLM platform.

![LLM Parameters](readme-images/pngs/LLMPrompt.png#gh-light-mode-only)
![LLM Parameters dark](readme-images/pngs/LLMPrompt_dark.png#gh-dark-mode-only)

<span style="color:crimson; font-size:150%; font-weight:bold">:exclamation: Pro tip: don't forget to hit the "save" button at the bottom. :exclamation:</span>

## TestSpark for JetBrains employees
JetBrains employees have the ability to send queries to OpenAI models through the [Grazie platform](https://try.ai.intellij.net/chat).

### Using Grazie platform

#### Pass Space username and token as properties

1) To include test generation using Grazie in the build process, you need to pass Space username and token as properties:\
   `gradle buildPlugin -Dspace.username=<USERNAME> -Dspace.pass=<TOKEN>`.

2) To include test generation using Grazie in the runIdeForUiTests process, you need to pass Space username and token as properties:\
   `gradle runIdeForUiTests -Dspace.username=<USERNAME> -Dspace.pass=<TOKEN>`.

3) `<TOKEN>` is generated by [Space](https://jetbrains.team/), which has access to `Automatically generating unit tests` maven packages.

#### Using `gradle.properties`

Store Space username and token in `~/.gradle/gradle.properties`
```
...
spaceUsername=<USERNAME>
spacePassword=<TOKEN>
...
```


### LLM Settings with Grazie
LLM Settings with Grazie platform option:

![LLM Grazie Settings](readme-images/pngs/LLMGrazieSettings.png#gh-light-mode-only)
![LLM Grazie Settings dark](readme-images/pngs/LLMGrazieSettings_dark.png#gh-dark-mode-only)

## Contribution
<!-- How to contribute to the plugin -->
The plugin is Open-Source and  publicly hosted on github. Anyone can look into the code and suggest changes. You can find the plugin page [here](https://github.com/ciselab/TestSpark).
## Licence
<!-- Which licence does the plugin have -->

---
Plugin based on the [IntelliJ Platform Plugin Template][template].

[template]: https://github.com/JetBrains/intellij-platform-plugin-template
