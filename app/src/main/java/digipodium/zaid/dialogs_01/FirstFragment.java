package digipodium.zaid.dialogs_01;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

public class FirstFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*1. data
                 * 2. adapter
                 * 3. alert dialog
                 * */
                final String[] fruits = new String[]{"Apple", "Banana", "Cherry", "Dragon fruit"};
                ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, fruits);
                AlertDialog dialog = new Builder(getActivity())
                        .setTitle("select you fruit")
                        .setAdapter(adapter, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                switch (which) {
                                    case 0:
                                        Toast.makeText(getActivity(), "you selected "+fruits[which], Toast.LENGTH_SHORT).show();
                                        break;
                                    case 1:
                                        Toast.makeText(getActivity(), "you selected "+fruits[which]+" is that ok", Toast.LENGTH_SHORT).show();
                                        break;
                                    case 2:
                                        Toast.makeText(getActivity(), "dont select "+fruits[which], Toast.LENGTH_SHORT).show();
                                        break;
                                    case 3:
                                        NavHostFragment.findNavController(FirstFragment.this).navigate(R.id.action_FirstFragment_to_SecondFragment);
                                        break;
                                }
                            }
                        })
                        .setNegativeButton("cancel", null)
                        .create();
                dialog.show();
            }
        });
    }
}