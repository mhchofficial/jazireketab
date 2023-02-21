package com.akatsuki.jazireketab.ui.fragments.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.akatsuki.jazireketab.MainActivity
import com.akatsuki.jazireketab.R
import com.akatsuki.jazireketab.databinding.FragmentCtegoryBinding
import com.akatsuki.jazireketab.databinding.FragmentSearchBinding
import com.akatsuki.jazireketab.ui.fragments.search.adapters.Suggestion_Adapter
import com.akatsuki.jazireketab.ui.fragments.search.viewmodel.SearchViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SearchFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SearchFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!


    private lateinit var _adapterSuggestion: Suggestion_Adapter




    private var viewModel: SearchViewModel? = null

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
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        val view = binding.root

        (activity as MainActivity).hideActionbar()
        (activity as MainActivity).updatetitle("جستجو")

        viewModel = ViewModelProvider(requireActivity())[SearchViewModel::class.java]
        _adapterSuggestion = Suggestion_Adapter()
        viewModel?.response?.observe(requireActivity(), Observer {
            binding.sugectionView.visibility = View.VISIBLE
            binding.searchResultRecyclerview.visibility = View.GONE
            _adapterSuggestion.items = it.data

        })

        binding.hotsugetionRecyclerviewSearch.apply {
            adapter = _adapterSuggestion
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
        }

        return view.rootView
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SearchFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SearchFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}