package org.jetbrains.research.testgenie.settings

import com.intellij.ide.ui.UINumericRange
import com.intellij.openapi.ui.ComboBox
import com.intellij.ui.JBIntSpinner
import com.intellij.ui.components.JBLabel
import com.intellij.util.ui.FormBuilder
import org.jdesktop.swingx.JXTitledSeparator
import org.jetbrains.research.testgenie.TestGenieLabelsBundle
import org.jetbrains.research.testgenie.TestGenieToolTipsBundle
import javax.swing.JPanel
import javax.swing.JTextField

class SettingsLLMComponent {
    var panel: JPanel? = null

    // LLM Token
    private var llmUserTokenField = JTextField(30)

    // Models
    private val contentDigestModels = ContentDigestModels()
    private var modelSelector = ComboBox(contentDigestModels.getModels())

    // Maximum number of LLM requests
    private var maxLLMRequestsField = JBIntSpinner(UINumericRange(SettingsApplicationState.DefaultSettingsApplicationState.maxLLMRequest, 1, 20))

    // The depth of input parameters used in class under tests
    private var maxInputParamsDepthField = JBIntSpinner(UINumericRange(SettingsApplicationState.DefaultSettingsApplicationState.maxInputParamsDepth, 1, 5))

    // Maximum polymorphism depth
    private var maxPolyDepthField = JBIntSpinner(UINumericRange(SettingsApplicationState.DefaultSettingsApplicationState.maxPolyDepth, 1, 5))

    init {
        // Adds the panel components
        createSettingsPanel()

        // Adds additional style (width, tooltips)
        stylizePanel()
    }

    private fun stylizePanel() {
        llmUserTokenField.toolTipText = TestGenieToolTipsBundle.defaultValue("llmToken")
        maxLLMRequestsField.toolTipText = TestGenieToolTipsBundle.defaultValue("maximumNumberOfRequests")
        modelSelector.toolTipText = "TODO"
        maxInputParamsDepthField.toolTipText = TestGenieToolTipsBundle.defaultValue("parametersDepth")
        maxPolyDepthField.toolTipText = TestGenieToolTipsBundle.defaultValue("maximumPolyDepth")
    }

    /**
     * Create the main panel for LLM-related settings page
     */
    private fun createSettingsPanel() {
        panel = FormBuilder.createFormBuilder()
            .addComponent(JXTitledSeparator(TestGenieLabelsBundle.defaultValue("LLMSettings")))
            .addLabeledComponent(
                JBLabel(TestGenieLabelsBundle.defaultValue("llmToken")),
                llmUserTokenField,
                10,
                false,
            )
            .addLabeledComponent(
                JBLabel("TODO"),
                modelSelector,
                10,
                false,
            )
            .addLabeledComponent(
                JBLabel(TestGenieLabelsBundle.defaultValue("parametersDepth")),
                maxInputParamsDepthField,
                10,
                false,
            )
            .addLabeledComponent(
                JBLabel(TestGenieLabelsBundle.defaultValue("maximumPolyDepth")),
                maxPolyDepthField,
                10,
                false,
            )
            .addLabeledComponent(
                JBLabel(TestGenieLabelsBundle.defaultValue("maximumNumberOfRequests")),
                maxLLMRequestsField,
                10,
                false,
            )
            .addComponentFillVertically(JPanel(), 0)
            .panel
    }

    var llmUserToken: String
        get() = llmUserTokenField.text
        set(newText) {
            llmUserTokenField.text = newText
        }

    var model: String
        get() = modelSelector.item
        set(newAlg) {
            modelSelector.item = newAlg
        }

    var maxLLMRequest: Int
        get() = maxLLMRequestsField.number
        set(value) {
            maxLLMRequestsField.number = value
        }

    var maxInputParamsDepth: Int
        get() = maxInputParamsDepthField.number
        set(value) {
            maxInputParamsDepthField.number = value
        }

    var maxPolyDepth: Int
        get() = maxPolyDepthField.number
        set(value) {
            maxPolyDepthField.number = value
        }
}
