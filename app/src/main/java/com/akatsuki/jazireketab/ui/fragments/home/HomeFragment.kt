package com.akatsuki.jazireketab.ui.fragments.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.akatsuki.jazireketab.R
import com.akatsuki.jazireketab.databinding.FragmentHomeBinding
import com.akatsuki.jazireketab.databinding.FragmentMyBooksBinding
import com.akatsuki.jazireketab.models.TopCatModel
import com.akatsuki.jazireketab.ui.fragments.home.adapters.*
import com.akatsuki.jazireketab.ui.fragments.home.viewmodels.HomeViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private var viewModel: HomeViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root


        //init viewmodel
        viewModel = ViewModelProvider(requireActivity())[HomeViewModel::class.java]


        val linearLayout = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)


        //dfine all adapters

        val catAdapter = Topcat_Adapter()
        val topListBlack = TopListBlack_Adapter()
        val topListWhite = TopListWhite_Adapter()
        val btm_one = Btm_list_one_Adapter()
        val btm_two = Btm_list_two_Adapter()
        val audio_list = Audio_Adapter()

        binding.topcatsList.apply {
            adapter = catAdapter
            layoutManager = linearLayout
            setHasFixedSize(true)

        }

        binding.toplistOneRecycler.apply {
            adapter = topListBlack
            layoutManager = linearLayout
            setHasFixedSize(true)

        }

        binding.posterListRecycler.apply {
            adapter = audio_list
            layoutManager = linearLayout
            setHasFixedSize(true)

        }

        binding.btmlistOneRecycler.apply {
            adapter = btm_one
            layoutManager = linearLayout
            setHasFixedSize(true)

        }

        binding.btmlistTwoRecycler.apply {
            adapter = btm_two
            layoutManager = linearLayout
            setHasFixedSize(true)
        }


        if (viewModel?.isLoading?.value!!){
            Log.e("loading", "true")
        }else{
            Log.e("loading", "false")
        }

        viewModel?.response?.observe(viewLifecycleOwner, Observer {
            if (it.result == "successful"){
                catAdapter.items = it.data.topCategory!!
                topListWhite.items = it.data.listTwoTop.listBooks
                topListBlack.items = it.data.listOneTop.listBooks
                btm_one.items = it.data.listOneBtm.listBooks
                btm_two.items = it.data.listTwoBtm.listBooks
                audio_list.items = it.data.listAudio.datas

                //names

                //ONE TOP
                binding.listSubjectOne.text = it.data.listOneTop.subject
                binding.listSubNameOne.text = it.data.listOneTop.subName
                //TWO TOP
                binding.listSubjectTwo.text = it.data.listTwoTop.subject
                binding.listSubNameTwo.text = it.data.listTwoTop.subName

                //ONE TOP
                binding.subjectPosterCenter.text = it.data.listAudio.name
                binding.listSubNameOne.text = it.data.listOneTop.subName
                //TWO TOP
                binding.listSubjectTwo.text = it.data.listTwoTop.subject
                binding.listSubNameTwo.text = it.data.listTwoTop.subName

                //poster name
                binding.subjectPosterCenter.text = it.data.listAudio.name

            }
        })


        return view.rootView
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}