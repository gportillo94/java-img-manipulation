import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.*;

public class ArchivosJFileChooser extends JFileChooser
{
	public ArchivosJFileChooser()
	{
		FileFilter filter = new FileNameExtensionFilter("Image","jpg","png");
		this.setFileFilter(filter);
	}
}