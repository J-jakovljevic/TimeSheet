
export interface User {
    id: number;
    name: string;
    surname: string;
    username: string;
    email: string;
    password: string;
    active: boolean;
    house_number: string;
    first_job_city: string;
    grandmother_name: string;
    first_pet: string;
    oldest_child: string;
    first_concert: string;
    first_car: string;
    parents_meet: string;
    favorite_place: string;
    dream_job: string;
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
    house_number: string;
    first_job_city: string;
    grandmother_name: string;
    first_pet: string;
    oldest_child: string;
    first_concert: string;
    first_car: string;
    parents_meet: string;
    favorite_place: string;
    dream_job: string;
}

export interface ChangePassword {
    email: string;
    newPassword: string;
    confirmPassword: string;
}

export interface ForgotPassword {
    mailTo: string;
    mailSubject: string;
    mailContent: string;
    question: string;

}

export interface CreateNewPassword {
    email: string;
    newPassword: string;
    confirmPassword: string;
}

export interface GetRandomQuestion {
    question: string;
}