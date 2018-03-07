import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		Merger merger = new Merger();
		Save saver = new Save();
		saver.saveTextFile(merger.getMergedList());
		merger.getAwayFile().deleteOnExit();
	}

}
