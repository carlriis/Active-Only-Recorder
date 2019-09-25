# Active Only Recorder
Active Only Recorder makes it easy to record action filled time lapses on your computer.Let’s say you want to make a programming time lapse, then there are going to be a lot of breaks where you aren't coding. Like when you read your own code or Stackoverflow to fix a bug. Or maybe you want to make a cup of coffee or sketch a concept on paper. This requires you to pause the time lapse, but Active only recorder only records when you are actively using your keyboard or mouse.
It’s written in Java and uses a library called Jnativehook and Ffmpeg. It's not error handled very well.

## Usage
*-ffmpeg*   **Ffmpeg path** This is the path to an ffmpeg executable. You can skip this if you have the executable in the same folder as the .jar file.

*-a*   **active time limit** This is when the recorder will pause the recording. The default is 5 seconds.

*-f*   **frame rate** This is the frame rate of the output video. The default is 30.

*-n*   **file name** This is the output filename. The default is time_lapse. It will automatically overwrite any file with the same name.

*-off*     **active checker off** This will turn off the active checker that pauses the time lapse. It will make your video a regular timelapse.

*-keeptmp*    **keep tmp folder** This will not clear the tmp folder which holds frames for ffmpeg. 

*-recordoff*  **recording off** This will not record but only encode the tmp folder. It will allow you to try different frame rates. 

## How to Run

```
sudo java -jar ActiveOnlyRecorder.jar
```
**NOTE: It's important that you run the program with administrator permissions**

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details