package dc.view.beans;


import dc.component.DCXhtmlComponent;
import dc.component.JSFDCComponent;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.event.ActionEvent;

import oracle.adf.view.rich.component.rich.layout.RichPanelSplitter;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.mds.internal.cust.BottomUpPolicyStrategy;

public class SampleBackingBean {
    private JSFDCComponent dcSampleBinding;
    private DCXhtmlComponent dcSampleBindingSecond;
    private RichPanelSplitter panelSplitterBinding;

    public SampleBackingBean() {
        super();
    }

    public void setDcSampleBinding(JSFDCComponent dcSampleBinding) {
        this.dcSampleBinding = dcSampleBinding;
    }

    public JSFDCComponent getDcSampleBinding() {
        return dcSampleBinding;
    }

    public void onClickMDS(ActionEvent actionEvent) {
        List<UIComponent> children = dcSampleBinding.getChildren(); // getting the child list from declarative component binding
        //MDSUtils.persistComponentAttribute( dcSampleBinding , "visible", false );  //This is for declative declarative 
        MDSUtils.persistComponentAttribute(children.get(0), "inlineStyle", "background-color:InfoBackground;");  //saving for child component.
        AdfFacesContext.getCurrentInstance().addPartialTarget(panelSplitterBinding);
    }

    public void onClickMDSSecond(ActionEvent actionEvent) {
        BottomUpPolicyStrategy dd;
        List<UIComponent> children = dcSampleBindingSecond.getChildren();
        System.err.println(dcSampleBindingSecond + " ----- DEBUG>> SampleBackingBean#onClickMDS : " + children.get(0));
        MDSUtils.persistComponentAttribute(children.get(0), "visible", false);
        AdfFacesContext.getCurrentInstance().addPartialTarget(panelSplitterBinding);
        // Add event code here...
    }

    public void setPanelSplitterBinding(RichPanelSplitter panelSplitterBinding) {
        this.panelSplitterBinding = panelSplitterBinding;
    }

    public RichPanelSplitter getPanelSplitterBinding() {
        return panelSplitterBinding;
    }

    public void setDcSampleBindingSecond(DCXhtmlComponent dcSampleBindingSecond) {
        this.dcSampleBindingSecond = dcSampleBindingSecond;
    }

    public DCXhtmlComponent getDcSampleBindingSecond() {
        return dcSampleBindingSecond;
    }
}
