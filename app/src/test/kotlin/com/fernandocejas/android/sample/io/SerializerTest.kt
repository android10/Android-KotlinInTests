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
package com.fernandocejas.android.sample.io

import com.fernandocejas.android.sample.users.UserEntity
import org.amshove.kluent.shouldEqual
import org.junit.Test

class SerializerTest {

    private val JSON_RESPONSE = "{\n \"id\": 1,\n " +
                                "\"cover_url\": \"http://www.android10.org/myapi/cover_1.jpg\",\n " +
                                "\"full_name\": \"Simon Hill\",\n " +
                                "\"description\": \"Curabitur gravida nisi at nibh. In hac habitasse " +
                                "platea dictumst. Aliquam augue quam, sollicitudin vitae, consectetuer " +
                                "eget, rutrum at, lorem.\\n\\nInteger tincidunt ante vel ipsum. " +
                                "Praesent blandit lacinia erat. Vestibulum sed magna at nunc commodo " +
                                "placerat.\\n\\nPraesent blandit. Nam nulla. Integer pede justo, " +
                                "lacinia eget, tincidunt eget, tempus vel, pede.\",\n " +
                                "\"followers\": 7484,\n " +
                                "\"email\": \"jcooper@babbleset.edu\"\n}"

    private var serializer = Serializer()

    @Test
    fun shouldSerialize() {
        val userEntityOne = serializer.deserialize(JSON_RESPONSE, UserEntity::class.java)
        val jsonString = serializer.serialize(userEntityOne, UserEntity::class.java)
        val userEntityTwo = serializer.deserialize(jsonString, UserEntity::class.java)

        userEntityOne.userId shouldEqual userEntityTwo.userId
        userEntityOne.fullname shouldEqual userEntityTwo.fullname
        userEntityOne.followers shouldEqual userEntityTwo.followers
    }

    @Test
    fun shouldDesearialize() {
        val userEntity = serializer.deserialize(JSON_RESPONSE, UserEntity::class.java)

        userEntity.userId shouldEqual 1
        userEntity.fullname shouldEqual "Simon Hill"
        userEntity.followers shouldEqual 7484
    }
}

