package com.owayed.kareen.kareentaskmangr2018.MyPageFragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.owayed.kareen.kareentaskmangr2018.adapters.MyHistoryAnimalRecyclerViewAdapter;
import com.owayed.kareen.kareentaskmangr2018.R;
import com.owayed.kareen.kareentaskmangr2018.data.Animal;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class HistoryAnimalFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;
    MyHistoryAnimalRecyclerViewAdapter adapter;
    List<Animal>animalList;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public HistoryAnimalFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static HistoryAnimalFragment newInstance(int columnCount) {
        HistoryAnimalFragment fragment = new HistoryAnimalFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_historyanimal_list, container, false);
        if (adapter == null) {
            animalList = new ArrayList<>();
            adapter = new MyHistoryAnimalRecyclerViewAdapter(animalList, mListener);
        }
        readAnimal();

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(adapter);
        }
        return view;
    }
//    public static class browser
//    {
//        private boolean browsing;
//        private WebHistoryItem currentVisit;
//
//        public static void main(String[]args)
//        {
//            Browser b = new Browser();
//            b.run();
//        }
//        public browser() {
//            browsing = true;
//            currentVisit = null;
//            System.out.println("Welcome to FCS Browser v0.01");
//        }
//        public void run() {
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            while (browsing) {
//                try {
//                    promptUser();
//                    String cmd = br.readLine();
//                    interpretAndExecute(cmd);
//                } catch (IOException e) {
//                    System.out.println("Oops! There was an error reading your command.");
//                }
//            }
//        }
//        private void promptUser() {
//            System.out.println("\nBrowser ready.\n(Commands: visit *web url*; history; back; quit; forward ;)");
//        }
//        private void interpretAndExecute(String cmd) {
//            String[] commands = cmd.split(" ");
//            if (cmd.equals("back")) {
//                goBack();
//            } else if (cmd.equals("history")) {
//                viewHistory();
//            } else if (commands[0].equals("visit")) {
//                visitPage(commands[1]);
//            } else if (cmd.equals("quit")) {
//                quit();
//            } else if (cmd.equals("forward")){
//                goForward();
//
//            } else {
//                System.out.println("Command not recognized");
//            }
//        }
//        private void visitPage(String url) {
//            System.out.println("Now going to visit "+url);
//            WebHistoryItem wv = new WebHistoryItem(url, currentVisit, null) {
//                @Override
//                public String getUrl() {
//                    return null;
//                }
//
//                @Override
//                public String getOriginalUrl() {
//                    return null;
//                }
//
//                @Override
//                public String getTitle() {
//                    return null;
//                }
//
//                @androidx.annotation.Nullable
//                @Override
//                public Bitmap getFavicon() {
//                    return null;
//                }
//
//                @Override
//                protected WebHistoryItem clone() {
//                    return null;
//                }
//            };
//            if (currentVisit != null) {
//                currentVisit.setNextNode(wv);
//            }
//            currentVisit = wv;
//            System.out.println(currentVisit);
//        }
//        private void goBack() {
//            if (currentVisit != null) {
//                System.out.println("Going back...");
//                currentVisit = currentVisit.getPreviousNode();
//                if (currentVisit != null) {
//                    System.out.println(currentVisit);
//                }
//            } else {
//                System.out.println("No web visits in browser history");
//            }
//        }private void goForward() {
//        if (currentVisit != null) {
//            System.out.print("Going forward...");
//            currentVisit = currentVisit.getNextNode();
//            if (currentVisit != null) {
//                System.out.println(currentVisit);
//            } else {
//                System.out.println("No next page to show.");
//            }
//        }
//    }
//        private void viewHistory() {
//            System.out.println("Showing browser history...");
//            WebHistoryItem tmp = currentVisit;
//            int counter = 0;
//            while (tmp != null) {
//                System.out.println("\t~"+tmp);
//                tmp = tmp.getPreviousNode();
//                counter++;
//            }
//            System.out.println("\t\t"+counter+" total");
//        }
//        private void quit() {
//            System.out.println("Quitting now...");
//            browsing = false;
//        }
//    }

    private List<Animal>readAnimal() {

        //reference to the database root
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

        reference.child("MyAnimals").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Toast.makeText(getContext(), "data changed", Toast.LENGTH_SHORT).show();
                animalList.clear();
                for (DataSnapshot d : dataSnapshot.getChildren()) {
                    Animal animal = d.getValue(Animal.class);

                    animalList.add(animal);


                }
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return animalList;
    }
            @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
     //       throw new RuntimeException(context.toString()
     //               + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(Animal item);
    }
}
