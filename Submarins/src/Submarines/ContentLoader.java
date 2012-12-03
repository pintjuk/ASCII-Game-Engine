package Submarines;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * a Class to handel loading Sprites frome file
 * @author Daniil
 *
 */
public class ContentLoader {
	private HashMap<String, Sprite> content = new HashMap<String, Sprite>();
	private String conterntDir;
	/**
	 * constructs a ContentLoader Object
	 * @param conterntDir
	 * the directore in witch the files are stored
	 * relative to project root derectory  
	 */
	public ContentLoader(String conterntDir) {
		this.conterntDir = conterntDir;
	}
	
	/**
	 * load Sprite frome file
	 * @param fileName
	 * the file name relative to the Content Directory, sufix excluded 
	 * @return
	 * returns loaded Sprite
	 */
	public Sprite Load(String fileName){
		if(content.containsKey(fileName)){
			return content.get(fileName);
		}else{
			String path = conterntDir+"/"+fileName+".sprite";
			
			char[][] data = LoadData(path);
			if(data == null)
				return null;
			else{
				
				return  new Sprite(data[0].length, data.length, data);//content.put(fileName, new Sprite(data[0].length, data.length, data));
			}
		}
	}
	
	private char[][] LoadData(String path){
		char[][] data;
		ArrayList<String> lines = new ArrayList<String>();
		File file = new File(path);
        StringBuffer contents = new StringBuffer();
        BufferedReader reader = null;
 
        try {
            reader = new BufferedReader(new FileReader(file));
            String text = null;
 
            // repeat until all lines is read
            while ((text = reader.readLine()) != null) {
            	lines.add(text);
            }
            
            int width = interpretLine(lines.get(0)).length;
            data = new char[lines.size()][width];
            for(int y = 0; y< lines.size();y++){
            	for(int x = 0; x<width; x++){
            		String line = lines.get(y);
            		char[] charline= interpretLine(line);
            		if(x<charline.length){
            			data[y][x] = charline[x];
            		}
            	}
            }
        } catch (FileNotFoundException e) {
        	data = null;
            e.printStackTrace();
        } catch (IOException e) {
        	data = null;
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        return data;
	}
	
	public char[] interpretLine(String line){
		char[] data = line.toCharArray();
		ArrayList<char[]> result = new ArrayList<char[]>();
		for(int i = 0; i< data.length; i++){
			if(data[i]=='\\'&&(i+1)<data.length){
				if(data[i+1]=='0'){
					result.add(new char[]{(char)0});
				}
				else
				if(data[i+1]=='\\'){
					result.add(new char[]{'\\'});
				}
				else
				if(data[i+1]=='n'){
					break;
				}
				i++;
			}else{
				result.add(new char[]{data[i]});
			}
		}
		char[] resultchar = new char[result.size()];
		
		for(int i=0; i<result.size();i++)
			resultchar[i] = result.get(i)[0];
		
		return resultchar;
	}

}
