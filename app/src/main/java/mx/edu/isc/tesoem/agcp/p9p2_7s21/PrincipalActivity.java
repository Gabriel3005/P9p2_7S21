package mx.edu.isc.tesoem.agcp.p9p2_7s21;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PrincipalActivity extends AppCompatActivity {

    ProgressBar pb1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        pb1=findViewById(R.id.pb1);

        ExecutorService execute = Executors.newSingleThreadExecutor();
        Future objeto = execute.submit(new Callable() {
            @Override
            public Object call() throws Exception {

                int contador=0;
                while (contador <100){
                  pb1.setProgress(contador);
                contador++;
                    int pausa=0;

            }

                return "Terminamos el hilo";
            }
        });
        try {
            Toast.makeText(this, "Mensaje" + objeto.get(), Toast.LENGTH_SHORT).show();
            execute.shutdown();
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}