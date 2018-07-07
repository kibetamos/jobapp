
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;
 
public class UserValueListener implements ValueChangeListener{

	@Override
	public void processValueChange(ValueChangeEvent event)
			throws AbortProcessingException {
		
		//access country bean directly
		Admin myadmin = (Admin) FacesContext.getCurrentInstance().
			getExternalContext().getSessionMap().get("AdminObj");
                String x = event.getNewValue().toString();
		myadmin.setUser(x);
                myadmin.setAge(x);
		
	}
	
	
}