package project.mobile.cau.sanchez.mathieu.mybmw;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class SerieFragment extends Fragment {

    TextView title;
    String titleString = "";
    ArrayList<MenuModel> list;
    ArrayList<String> listForListView;

    public SerieFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView( @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {

        assert getArguments() != null;
        titleString = getArguments().getString( "title" );
        list = (ArrayList< MenuModel >) getArguments().getSerializable( "list" );
        listForListView = new ArrayList<>();

        for ( MenuModel model : list ) {
            listForListView.add( model.menuName );
        }

        Log.d( "Serie Fragment", titleString + list.toString() );

        return inflater.inflate( R.layout.fragment_serie, container, false );
    }

    @Override
    public void onViewCreated( @NonNull View view, @Nullable Bundle savedInstanceState ) {
        super.onViewCreated( view, savedInstanceState );

        title = view.findViewById( R.id.title );
        title.setText( titleString );
    }
}
