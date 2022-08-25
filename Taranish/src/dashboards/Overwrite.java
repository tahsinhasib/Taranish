package dashboards;
import loginsignups.*;
import transactions.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.lang.*;

public class Overwrite {
	public static void setVariable(int lineNumber, String data) throws IOException {
	    Path path = Paths.get("C:\\Users\\TAHSIN\\Desktop\\TARANISH OOP-1 Final Project\\Project Taranish\\src\\data\\game_data.txt");
	    List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
	    lines.set(lineNumber - 1, data);
	    Files.write(path, lines, StandardCharsets.UTF_8);
	}
}
