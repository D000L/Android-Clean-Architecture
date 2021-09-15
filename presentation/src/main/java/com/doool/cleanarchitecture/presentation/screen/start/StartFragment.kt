package com.doool.cleanarchitecture.presentation.screen.start

/*

@AndroidEntryPoint
class StartFragment : BaseFragment<FragmentStartBinding>(R.layout.fragment_start) {

    private val splashViewModel by viewModels<StartViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupObserve()

        splashViewModel.checkServerOn()
    }

    private fun setupObserve() {
        with(splashViewModel) {
            serverOn.observe(viewLifecycleOwner) {
                dataBinding.startServerState.text = if (it) "Server On" else "Server Off"
                if (it) {
                    //findNavController().navigate(StartFragmentDirections.actionStartFragmentToApiListFragment())
                } else {
                    activity?.finish()
                }
            }
        }
    }
}*/
