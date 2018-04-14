package com.example.kirill.greenme;

import android.content.Context;
import android.os.AsyncTask;

import com.here.odnp.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class AsyncComplex extends AsyncTask<String, Void, String> {
    private Context mContext;
    private TaskCompleted mCallback;

    public AsyncComplex(Context context){
        this.mContext = context;
        this.mCallback = (TaskCompleted) context;

    }
    @Override
    protected String doInBackground(String... commands) {
    String command = commands[0];
    try {
        //TODO: make this configurable inside the app
        Socket socket = new Socket("10.0.1.132", 3030);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        out.println(command);


        //read input stream
        DataInputStream dis2 = new DataInputStream(socket.getInputStream());
        InputStreamReader disR2 = new InputStreamReader(dis2);
        BufferedReader br = new BufferedReader(disR2);//create a BufferReader object for input
        StringBuilder str = new StringBuilder();
        String line = null;
        int num = 3;
        while ((line = br.readLine()) != null) {
            str.append(line);
        }



        dis2.close();
        socket.close();
        Log.v("lalala", "lallss");
        return str.toString();
    } catch (IOException ioe) {
    }
    return null;
    }

    @Override
    protected void onPostExecute(String results) {
        //This is where you return data back to caller
        mCallback.onTaskComplete(results);
    }
}
