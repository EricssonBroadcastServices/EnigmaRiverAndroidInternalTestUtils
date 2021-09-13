package com.redbeemedia.enigma.core.util;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;

import java.io.ByteArrayOutputStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/** Load test data from files.
 The files must be located in a "resource" folder containing a
 package with the package name equal to the file in a package loading the resource.
 Example:
 If your package name is <code>com.redbeemedia.enigma.core.player</code>, the
 folder for the test resource file should be located in
 <p><code>src/test/resources/com/redbeemedia/enigma/core/player</code>.</p>
 <h3>Example usage</h3>
 <code><p>TestResourceLoader resourceLoader = new TestResourceLoader(getClass());</p>
 <p>JSONObject jsonRespons = resourceLoader.loadJSON("jsonfile.json");</p>
 <p>String textResponse = resourceLoader.loadString("some.text.txt");</p>
 <p>byte[] rawResponse = resourceLoader.loadBytes("binary.file.raw");</p>
 </code>

 */
public class TestResourceLoader {

    private final Class classType;

    /**
     * In order to load resources, the package name of the
     * file being loaded must equal to the class loading the class.
     * @param classType The class that requires the resource.
     */
    public TestResourceLoader(Class classType) {
        this.classType = classType;
    }

    /** Returns an byte array containing the file data. */
    public byte[] loadBytes(String name) throws IOException {

        InputStream inputStream = classType.getResourceAsStream(name);

        if (inputStream == null) { throw new IOException("File not found: " + name); }

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int nRead;
        byte[] data = new byte[1024];
        while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }

        buffer.flush();
        return buffer.toByteArray();
    }

    /**
     * Loads the content of a file into a string.
     * @param name the name of the file resource.
     */
    public String loadString(String name) throws IOException {

        InputStream inputStream = classType.getResourceAsStream(name);

        if (inputStream == null) { throw new IOException("File not found: " + name); }

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        for (String line; (line = bufferedReader.readLine()) != null; ) {
            stringBuilder.append(line).append('\n');
        }
        return stringBuilder.toString();
    }

    /**
     * Loads data and return it as a JSON object.
     */
    public JSONObject loadJSON(String name) throws IOException, JSONException {

        return new JSONObject(loadString(name));

    }
}
