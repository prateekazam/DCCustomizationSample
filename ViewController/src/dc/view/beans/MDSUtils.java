package dc.view.beans;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import oracle.adf.view.rich.change.MDSDocumentChangeManager;
import oracle.adf.view.rich.context.AdfFacesContext;

import org.apache.myfaces.trinidad.change.AttributeComponentChange;
import org.apache.myfaces.trinidad.change.AttributeDocumentChange;
import org.apache.myfaces.trinidad.util.ComponentUtils;

public class MDSUtils
{
    public MDSUtils()
    {
        super();
    }

    public static void persistComponentAttribute( UIComponent component, String attribute, Object value )
    {
        final FacesContext context = FacesContext.getCurrentInstance();
        final AttributeDocumentChange change = new AttributeDocumentChange( attribute, value.toString() );
        final MDSDocumentChangeManager cm = ( MDSDocumentChangeManager ) AdfFacesContext.getCurrentInstance().getPersistentChangeManager();
        cm.addDocumentChangeWithOutcome( context, component, change );
        final AttributeComponentChange attrChange = new AttributeComponentChange( attribute, value );
        attrChange.changeComponent( component );
        System.err.println( "----- DEBUG>> MDSUtils#persistComponentAttribute : " +getPagePath(context,component));
    }


    public static String getPagePath( FacesContext facesContext, UIComponent component )
    {
        return ComponentUtils.getDocumentLocationForComponent( facesContext, component );
    }


}
