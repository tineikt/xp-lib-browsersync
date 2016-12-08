import org.osgi.service.component.annotations.Component;
import com.enonic.xp.event.Event;
import com.enonic.xp.event.EventListener;
import com.enonic.xp.server.RunMode;

@Component(immediate = true)
public class AdminBrowsersyncListener
implements EventListener
{

	private static final Boolean DEV_MODE = RunMode.get().equals(RunMode.DEV);

	@Override
	public void onEvent( final Event event)
	{
		if(DEV_MODE) {
			String eventType = event.getType();

			if(eventType.equals("node.updated") || eventType.equals("node.created") || eventType.equals("node.deleted")) {
				try {
					Runtime rt = Runtime.getRuntime();
					Process pr = rt.exec("browser-sync reload");
				} catch(Exception e) {
					throw new RuntimeException( e );
				}
			}
		}
	}
}
