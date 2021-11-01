package Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lesson35.R;
import com.example.lesson35.databinding.FragmentThirdBinding;


public class ThirdFragment extends Fragment {
    private FragmentThirdBinding binding;
    private String text;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentThirdBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FourthFragment fragment = new FourthFragment();
        Bundle bundle = this.getArguments();
        if (bundle != null) {
           text = bundle.getString("key2","");

        }

        binding.btnThird.setOnClickListener(v -> {
            Bundle bundle1 = new Bundle();
            bundle1.putString("key",text);
            requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new FourthFragment()).commit();
            fragment.setArguments(bundle1);

        });
    }
}