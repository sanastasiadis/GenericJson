package org.stavros.json;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class JSONRunner {
	
	private BufferedReader br;
	
	public JSONRunner(InputStream in) {
		try {
			br = new BufferedReader(new InputStreamReader(in));
		}
		catch(Exception e) {
			
		}
	}
	
	public String get(String key) throws GenericJsonException {
		try {
			int w = br.read();
			while (w == ' ') {
				w = br.read();
			}
			
			if (w == '{') {
				int a = br.read();
				StringBuilder sb = new StringBuilder();
				while(a != ':') {
					if ((a == '{') || (a == '[')) {
						throw new GenericJsonException(ErrorCode.INVALID_CALL);
					}
					else if (a == '"') {
						a = br.read();
						sb.append(a);
					}
				}
				return sb.toString();
			}
			else {
				throw new GenericJsonException(ErrorCode.INVALID_CALL);
			}
		}
		catch(Exception e) {
			throw new GenericJsonException(ErrorCode.IO);
		}
	}
}
