
package agribpo.sona.myandroidappintamilenglish;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity
{

    Button tamil, english;
    String currentLanguage;
    TextView news;
    Typeface tamilfont, englishfont;
    Context context;
    Configuration config;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**Initialization          */

        currentLanguage = "";
        tamil =(Button)findViewById(R.id.tamil);
        english = (Button)findViewById(R.id.english);

        news = (TextView)findViewById(R.id.news);

        /** Initialization of Fontss          */

        tamilfont = Typeface.createFromAsset(getAssets(), "fonts/bamini.ttf");
        englishfont = Typeface.createFromAsset(getAssets(), "fonts/cambria.ttf");


        tamil.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                /**
                 * "tam" is the localization code for our tamil language
                 */
                currentLanguage = "ta";
                Locale mylocale = new Locale(currentLanguage);


                Locale.setDefault(mylocale);
                System.out.println("My Current Language: "+Locale.getDefault());
                config = new Configuration();
                config.locale = mylocale;
                getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
               // android.content.res.Resources res = getBaseContext().getResources();
               // System.out.println("My current Resources"+res);
                news.setTypeface(tamilfont);
                String cont = getResources().getString(R.string.note);
                Log.d("My tag", cont);

                news.setText(cont);

            }
        });

        english.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                currentLanguage = "eng";
                Locale locale = new Locale(currentLanguage);
                Locale.setDefault(locale);

                //print the current language
                System.out.println("MyCurrent Lanaguage :"+Locale.getDefault());
                config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                android.content.res.Resources res = getBaseContext().getResources();

                android.content.res.Resources res1 = getBaseContext().getResources();
                String con = res1.getString(R.string.note);
                Log.d("My tag", con);
                news.setTypeface(englishfont);
                news.setText(R.string.note);

            }
        });

    }
}
