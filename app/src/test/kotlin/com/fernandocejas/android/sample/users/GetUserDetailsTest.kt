package com.fernandocejas.android.sample.users

import com.fernandocejas.android.sample.executor.PostExecutionThread
import com.fernandocejas.android.sample.executor.ThreadExecutor
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.verifyNoMoreInteractions
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.verifyZeroInteractions

class GetUserDetailsTest {

    private val USER_ID = 123

    private lateinit var getUserDetails: GetUserDetails

    private val userRepository: UserRepository = mock()
    private val threadExecutor: ThreadExecutor = mock()
    private val postExecutionThread: PostExecutionThread = mock()

    @Before
    fun setUp() {
        getUserDetails = GetUserDetails(userRepository, threadExecutor, postExecutionThread)
    }

    @Test
    fun shouldGetUserDetails() {
        getUserDetails.buildUseCaseObservable(GetUserDetails.Params.forUser(USER_ID));

        verify(userRepository).user(USER_ID)
        verifyNoMoreInteractions(userRepository)
        verifyZeroInteractions(postExecutionThread)
        verifyZeroInteractions(threadExecutor)
    }
}
