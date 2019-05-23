package ro.pub.cs.systems.eim.practicaltest02;

import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import ro.pub.cs.systems.eim.practicaltest02.Constants;
import ro.pub.cs.systems.eim.practicaltest02.Utilities;

public class ClientThread extends Thread {

    private String address;
    private int port;
    private String url;
    private TextView weatherForecastTextView;

    private Socket socket;

    public ClientThread(String address, int port, String url, TextView weatherForecastTextView) {
        this.address = address;
        this.port = port;
        this.url = url;
        this.weatherForecastTextView = weatherForecastTextView;
    }

    @Override
    public void run() {
        try {
            Log.e(Constants.TAG, "[CLIENT THREAD] Start running");
            socket = new Socket(address, port);
            if (socket == null) {
                Log.e(Constants.TAG, "[CLIENT THREAD] Could not create socket!");
                return;
            }
            BufferedReader bufferedReader = Utilities.getReader(socket);
            PrintWriter printWriter = Utilities.getWriter(socket);
            if (bufferedReader == null || printWriter == null) {
                Log.e(Constants.TAG, "[CLIENT THREAD] Buffered Reader / Print Writer are null!");
                return;
            }

            printWriter.println(url);
            printWriter.flush();

            Log.e(Constants.TAG, "[CLIENT THREAD] request sent");

            String weatherInformation = "";
            String aux;
            while ((aux = bufferedReader.readLine()) != null) {
                weatherInformation += aux;
            }

            final String result = weatherInformation;
            Log.e(Constants.TAG, "[CLIENT THREAD] received data: " + result);

            weatherForecastTextView.post(new Runnable() {
                @Override
                public void run() {
                    weatherForecastTextView.setText(result);
                }
            });

        } catch (IOException ioException) {
            Log.e(Constants.TAG, "[CLIENT THREAD] An exception has occurred: " + ioException.getMessage());
            if (Constants.DEBUG) {
                ioException.printStackTrace();
            }
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException ioException) {
                    Log.e(Constants.TAG, "[CLIENT THREAD] An exception has occurred: " + ioException.getMessage());
                    if (Constants.DEBUG) {
                        ioException.printStackTrace();
                    }
                }
            }
        }
    }

}
