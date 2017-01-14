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

import com.fernandocejas.android.sample.AndroidTest
import org.amshove.kluent.shouldEqualTo
import org.junit.After
import org.junit.Test
import java.io.File

class FileManagerTest : AndroidTest() {

    private var fileManager = FileManager()

    @After
    fun tearDown() {
        fileManager.clearDirectory(cacheDir())
    }

    @Test
    fun shouldWriteToFile() {
        val fileToWrite = createDummyFile()
        val fileContent = "content"

        fileManager.writeToFile(fileToWrite, fileContent)

        fileToWrite.exists() shouldEqualTo true
    }

    @Test
    fun shouldHaveCorrectFileContent() {
        val fileToWrite = createDummyFile()
        val fileContent = "content\n"

        fileManager.writeToFile(fileToWrite, fileContent)
        val expectedContent = fileManager.readFileContent(fileToWrite)

        expectedContent shouldEqualTo fileContent
    }

    private fun createDummyFile(): File {
        val dummyFilePath = cacheDir().path + File.separator + "dummyFile"
        return File(dummyFilePath)
    }
}

