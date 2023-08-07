package ru.energostalin.autoauth.lib

import ru.energostalin.autoauth.lib.generators.PlainPasswordGenerator
import ru.energostalin.autoauth.lib.storages.JsonStorage
import net.fabricmc.loader.api.FabricLoader
import kotlin.io.path.createDirectory
import kotlin.io.path.exists

object PasswordManagerFactory {
    fun createDefault(): PasswordManager {
        val folder = FabricLoader.getInstance().configDir.resolve("AutoAuth")

        if(!folder.exists())
            folder.createDirectory()

        val storage = JsonStorage(folder)
        return PasswordManager(storage, PlainPasswordGenerator())
    }
}