import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class StorageService {
    appStorage: Storage;
    constructor() {
        this.appStorage = window.sessionStorage;
    }

    /** Returns null when not supported and when not found */
    get(key: string): any {
        if (this.isLocalStorageSupported) {
            return JSON.parse(this.appStorage.getItem(key));
        }
        return null;
    }
    set(key: string, value: any): boolean {
        if (this.isLocalStorageSupported) {
            this.appStorage.setItem(key, JSON.stringify(value));
            return true;
        }
        return false;
    }
    remove(key: string): boolean {
        if (this.isLocalStorageSupported) {
            this.appStorage.removeItem(key);
            return true;
        }
        return false;
    }

    removeAll() {
        if (this.isLocalStorageSupported) {
            this.appStorage.clear();
        }
    }

    get isLocalStorageSupported(): boolean {
        return !!this.appStorage
    }

    getToken(): string {
        let token = this.get('token')
        if (token == null) {
            return ''
        }
        return token
    }

}