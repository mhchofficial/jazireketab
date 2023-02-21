package com.akatsuki.jazireketab.ui.fragments.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.akatsuki.jazireketab.MainActivity
import com.akatsuki.jazireketab.R
import com.akatsuki.jazireketab.databinding.FragmentHomeBinding
import com.akatsuki.jazireketab.databinding.FragmentMyBooksBinding
import com.akatsuki.jazireketab.models.TopCatModel
import com.akatsuki.jazireketab.models.test.Books
import com.akatsuki.jazireketab.models.test.DataX
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

        (activity as MainActivity).showActionbar()

        //init viewmodel
        viewModel = ViewModelProvider(requireActivity())[HomeViewModel::class.java]


        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false);
        (activity as MainActivity).supportActionBar?.setDisplayShowHomeEnabled(false);

        //dfine all adapters

        val catAdapter = Topcat_Adapter()
        val topListtwo = TopListBlack_Adapter()
        val topListone = TopListWhite_Adapter()
        val btm_one = Btm_list_one_Adapter()
        val btm_two = Btm_list_two_Adapter()
        val audio_list = Audio_Adapter()

        binding.topcatsList.apply {
            adapter = catAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)

        }

        binding.toplistOneRecycler.apply {
            adapter = topListone
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)

        }

        binding.toplistTwoRecycler.apply {
            adapter = topListtwo
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)

        }

        binding.posterListRecycler.apply {
            adapter = audio_list
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)

        }

        binding.btmlistOneRecycler.apply {
            adapter = btm_one
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)

        }

        binding.btmlistTwoRecycler.apply {
            adapter = btm_two
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
        }

        audio_list.setOnItemClickListener(object: Audio_Adapter.OnItemCLick{
            override fun onClick(item: DataX) {
                findNavController().navigate(R.id.action_homeFragment_to_audioDetailsFragment)
            }

        })


        topListone.setOnItemClickListener(object: TopListWhite_Adapter.OnItemCLick{

            override fun onClick(item: Books) {
                findNavController().navigate(R.id.action_homeFragment_to_bookDetailsFragment)
            }

        })

        binding.watchAllOne.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_listFragment)
        }

        binding.watchAllTwo.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_listFragment)
        }

        binding.watchAllListTwo.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_listFragment)
        }

        binding.watchBottomListTwo.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_listFragment)
        }

        (activity as MainActivity).toolbar.findViewById<ImageView>(R.id.share).setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_shareFragment)
        }


        (activity as MainActivity).toolbar.findViewById<ImageView>(R.id.help).setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_homeFragment_to_helpFragment)
        }





        viewModel?.response?.observe(viewLifecycleOwner, Observer {
            if (it.result == "successful"){
                catAdapter.items = it.data.topCategory
                topListtwo.items = it.data.listTwoTop.listBooks
                topListone.items = it.data.listOneTop.listBooks
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

                //one btm
                binding.listBottomSubjectOne.text = it.data.listOneBtm.subject

                //two btm
                binding.listBottomSubjectTwo.text = it.data.listTwoBtm.subject

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