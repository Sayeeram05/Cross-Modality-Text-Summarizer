import java.io.*;

public class RunPythonScript {
    public void Process(String Path){
        try {
            // Set the Python script directory
            File scriptDir = new File("D:\\GitHub\\Cross Modality Text Summarizer");
            ProcessBuilder pb = new ProcessBuilder("python", "Test1.py");
            pb.directory(scriptDir);  // Set working directory
            pb.redirectErrorStream(true);

            Process process = pb.start();

            // Send input to Python
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));

            writer.write(Path);
            writer.flush();
            writer.close();  // Important!

            // Read output from Python
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Python returned: " + line);
            }

            int exitCode = process.waitFor();
            System.out.println("Python script exited with code " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
