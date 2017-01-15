/**
 * Copyright (C) 2017 Fernando Cejas Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.fernandocejas.android.sample.ui

import com.fernandocejas.android.sample.R
import com.fernandocejas.android.sample.ui.framework.AcceptanceTest
import org.junit.Test

class HelloWorldActivityTest : AcceptanceTest<HelloWorldActivity>(HelloWorldActivity::class.java, false) {

    @Test
    fun shouldSayHelloWorld() {
        checkThat.viewContainsText(R.id.hello, R.string.hello)
    }
}
