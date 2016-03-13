package org.elsys.funcgeo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Picture {

	private List<String> figure;
	private Picture(List<String> figure) {
		this.figure = figure;
	}
	
	public static Picture load(Path file) {
		try {
			List<String> figure = 
					Files.lines(file)
					.collect(Collectors.toList());
			return new Picture(figure);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Picture(Collections.emptyList());
	}
	
	public void saveSvg(Path file) {
		try (BufferedWriter writer = Files.newBufferedWriter(file)) {
			writer.write("<svg xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" version=\"1.2\" width=\"520mm\" height=\"520mm\" viewBox=\"0 0 520 520\" stroke=\"none\" fill=\"#000000\" stroke-width=\"0.3\" font-size=\"3.88\" >");
			writer.newLine();
			writer.write("<g transform=\"translate(130 130)\">");
			writer.newLine();
			for(String line: figure) {
				writer.write(line);
				writer.newLine();
			}
			writer.newLine();
			writer.write("</g>");
			writer.newLine();
			writer.write("</svg>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Picture rot() {
		List<String> result = new ArrayList<>();
		result.add("<g transform=\"translate(130 130) rotate(-90) translate(-130 -130)\">");
		for(String line: figure) {
			result.add(line);
		}
		result.add("</g>");
		return new Picture(result);
	}
	
	public Picture flip() {
		List<String> result = new ArrayList<>();
		result.add("<g transform=\"scale(-1, 1) translate(-260, 0)\">");
		for(String line: figure) {
			result.add(line);
		}
		result.add("</g>");
		return new Picture(result);
	}

	public Picture rot45() {
		List<String> result = new ArrayList<>();
		result.add("<g transform=\"scale(0.707107)\">");
		result.add("<g transform=\"rotate(-45)\">");
		for(String line: figure) {
			result.add(line);
		}
		result.add("</g>");
		result.add("</g>");
		return new Picture(result);
	}
	
	
	public Picture above(Picture g) {
		List<String> result = new ArrayList<>();
		
		result.add("<g transform=\"scale(1, 0.5)\">");
		for(String line: figure) {
			result.add(line);
		}
		result.add("</g>");
		
		result.add("<g transform=\"translate(0, 130)\">");
		result.add("<g transform=\"scale(1, 0.5)\">");
		for(String line: g.figure) {
			result.add(line);
		}
		result.add("</g>");
		result.add("</g>");
		
		return new Picture(result);
		
	}

	public Picture beside(Picture g) {
		List<String> result = new ArrayList<>();
		
		result.add("<g transform=\"scale(0.5, 1)\">");
		for(String line: figure) {
			result.add(line);
		}
		result.add("</g>");
		
		result.add("<g transform=\"translate(130, 0)\">");
		result.add("<g transform=\"scale(0.5, 1)\">");
		for(String line: g.figure) {
			result.add(line);
		}
		result.add("</g>");
		result.add("</g>");
		
		return new Picture(result);
	}

	public Picture over(Picture g) {
		List<String> result = new ArrayList<>();

		result.add("<g >");
		
		for(String line: figure) {
			result.add(line);
		}
		
		for(String line: g.figure) {
			result.add(line);
		}
		result.add("</g>");
		
		return new Picture(result);
	}
	
	public static void main(String[] args) {
		Picture fish = Picture.load(Paths.get("fish1.svg"));
		Picture fish2 = fish.rot45().flip();
		Picture fish3 = fish2.rot().rot().rot();
		
		fish2.saveSvg(Paths.get("fish2.svg"));
		fish3.saveSvg(Paths.get("fish3.svg"));
		
		fish2.over(fish3).saveSvg(Paths.get("output.svg"));
		
		Picture t = fish.over(fish2.over(fish3));
		t.saveSvg(Paths.get("t.svg"));
		
		Picture u = fish2.over(fish2.rot()).over(fish2.rot().rot().over(fish2.rot().rot().rot()));
		u.saveSvg(Paths.get("u.svg"));
		
	}

}
