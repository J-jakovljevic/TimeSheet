
export interface User {
    id: number;
    name: string;
    surname: string;
    username: string;
    email: string;
    password: string;
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

export interface ChangePassword {
    email: any;
    newPassword: string;
    confirmPassword: string;
}

export interface ForgotPassword {
    mailTo: any;
    mailSubject: string;
    mailContent: any;

}

export interface CreateNewPassword {
    email: any;
    newPass: string;
    confirmPass: string;
}