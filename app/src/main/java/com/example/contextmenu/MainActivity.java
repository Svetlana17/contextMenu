package com.example.contextmenu;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int IDM_OPEN = 101;
    public static final int IDM_SAVE = 102;
    public static final int IDM_ESC = 103;

    public TextView textview2;


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textview = (TextView)findViewById(R.id.textView);
        textview2 = (TextView)findViewById(R.id.textView2);

        registerForContextMenu(textview);
        registerForContextMenu(textview2);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        // программное конт  екстного добавление меню
        menu.add(Menu.NONE, IDM_OPEN, 1, "Открыть");
        menu.add(Menu.NONE, IDM_SAVE, 2, "Сохранить");
        menu.add(Menu.NONE, IDM_ESC, 3, "Отмена");

       /* У метода add() есть четыре параметра:

    идентификатор группы - позволяет связывать пункт меню с группой других пунктов этого меню
        идентификатор пункта для обработчика события выбора пункта меню
        порядок расположения пункта в меню - позволяет определять позицию в меню.
         По умолчанию (Menu.NONE или 0) пункты идут в том порядке, как задано в коде
        заголовок - текст, который выводится в пункте меню. Можно использовать строковый ресурс
        */
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        CharSequence message;
        switch (item.getItemId()) {
            case IDM_OPEN:
                message = "Выбран пункт Открыть";
                break;
            case IDM_SAVE:
                message = "Выбран пункт Сохранить";
                break;
//            case R.id.change_color:
//                message = "Меняем цвет";
//                textview2.setBackgroundColor(Color.RED);
//                break;
            case R.id.change_textsize:
                message = "Меняем размер шрифта";
                textview2.setTextSize(18);
                break;

            default:
                return super.onContextItemSelected(item);
        }
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
        return true;
    }  }