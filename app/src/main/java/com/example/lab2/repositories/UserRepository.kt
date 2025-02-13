package com.example.lab2.repositories

import com.example.lab2.User


class UserRepository {
        suspend fun getUser(): User {
            // Mock Data
            return User(1, "John Doe", "john.doe@example.com")
        }

        suspend fun updateUser(user: User): User {
            // Mock updating user
            return user
        }
    }
