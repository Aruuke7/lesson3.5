package Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lesson35.R;
import com.example.lesson35.databinding.FragmentFourthBinding;


public class FourthFragment extends Fragment {

    private FragmentFourthBinding binding;
    private String text;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFourthBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FifthFragment fragment = new FifthFragment();
        Bundle bundle = getArguments();
        if (bundle != null) {
            text = bundle.getString("key","");
            binding.textView4.setText(text);
            Log.d("ololo", "onViewCreated: fourth получил "+text);
        }


        binding.btnFourth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle1 = new Bundle();
                bundle1.putString("key2",text);
                Log.d("ololo", "onViewCreated: fourth передал"+text);
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
                fragment.setArguments(bundle1);
            }
        });


    }
}