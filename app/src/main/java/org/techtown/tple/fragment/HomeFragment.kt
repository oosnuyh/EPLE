package org.techtown.tple.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.techtown.tple.home.user.DataHomeUser
import org.techtown.tple.home.user.HomeUserAdapter
import org.techtown.tple.MainActivity
import org.techtown.tple.R
import org.techtown.tple.databinding.FragmentHomeBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment(R.layout.fragment_home) {

    lateinit var binding: FragmentHomeBinding
    lateinit var userList : ArrayList<DataHomeUser>
    lateinit var mainActivity: MainActivity
    lateinit var homeUserRV : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false)

        homeUserRV = binding.HomeUserRV
        userList = ArrayList<DataHomeUser>()
        userList.add(DataHomeUser("","hi"))
        userList.add(DataHomeUser("","hello"))
        userList.add(DataHomeUser("","hyunsoo"))
        userList.add(DataHomeUser("","qwer"))
        userList.add(DataHomeUser("","asdf"))
        userList.add(DataHomeUser("","test"))
        userList.add(DataHomeUser("","EPLE"))

        val homeUserRVAdapter = HomeUserAdapter(mainActivity,userList.toMutableList())
        homeUserRV.adapter = homeUserRVAdapter
        // Inflate the layout for this fragment


        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        mainActivity = context as MainActivity
    }

    fun setRecyclerView(){

        val homeUserRVAdapter = HomeUserAdapter(mainActivity,userList.toMutableList())
        homeUserRV.adapter = homeUserRVAdapter

    }
    //

//    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment HomeFragment.
//         */
//        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            HomeFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
//    }
}