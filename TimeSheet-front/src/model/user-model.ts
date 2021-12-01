export interface User {
    id: number;
    name: string;
    surname: string;
    username: string;
    email: string;
    password: string;
    confirmPassword: string;
    active: boolean;
}

export interface LoginUser {
    email: string;
    username: string;
    password: string;
}

export interface RegisterUser {
    name: string;
    surname: string;
    username: string;
    email: string;
    password: string;
    confirmPassword: string;
}