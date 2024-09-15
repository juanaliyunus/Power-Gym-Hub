package com.work.baseapp.controller;

public class UserController {
    // 1. GET /api/all/user: Mendapatkan daftar semua pengguna (ADMIN)
    //    - Response: List<UserResponse> (id, username, email, role)

    // 2. GET /api/user/{id}: Mendapatkan informasi pengguna berdasarkan ID (ADMIN, USER)
    //    - Request: {id} sebagai path variable
    //    - Response: UserResponse (id, username, email, role)

    // 3. POST /api/users: Menambahkan pengguna baru (ADMIN)
    //    - Request: UserRequest (username, email, password, role)
    //    - Response: UserResponse (id, username, email, role)

    // 4. PUT /api/users/{id}: Memperbarui informasi pengguna berdasarkan ID (ADMIN, USER)
    //    - Request: {id} sebagai path variable, UserRequest untuk data yang diubah
    //    - Response: UserResponse (id, username, email, role)

    // 5. DELETE /api/users/{id}: Menghapus pengguna berdasarkan ID (ADMIN, USER)
    //    - Request: {id} sebagai path variable
    //    - Response: Status 204 No Content jika berhasil
}
