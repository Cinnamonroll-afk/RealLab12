import type { Organizer } from '@/type'
import apiClient from './AxiosClient'
import type { AxiosResponse } from 'axios'

export default {
    getOrganizers(): Promise<AxiosResponse<Organizer[]>> {
        return apiClient.get<Organizer[]>('/organizers')
    }
}