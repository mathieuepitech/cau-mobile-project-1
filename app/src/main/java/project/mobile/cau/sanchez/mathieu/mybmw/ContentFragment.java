package project.mobile.cau.sanchez.mathieu.mybmw;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContentFragment extends Fragment {

    String titleString = "";
    TextView title;

    public ContentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView( @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {
        assert getArguments() != null;
        titleString = getArguments().getString( "title" );

        return inflater.inflate( R.layout.fragment_content, container, false );
    }

    @Override
    public void onViewCreated( @NonNull View view, @Nullable Bundle savedInstanceState ) {
        super.onViewCreated( view, savedInstanceState );

        title = view.findViewById( R.id.title );
        title.setText( titleString );
    }
}
