import type { Participant } from '@/type'
import apiClient from './AxiosClient'
import type { AxiosResponse } from 'axios'

export default {
  /**
   * Fetches the list of all participants from the backend API.
   */
  getParticipants(): Promise<AxiosResponse<Participant[]>> {
    return apiClient.get<Participant[]>('/participants')
  }
}
